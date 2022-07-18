import { useState } from 'react';

function GameForm({ Game: initialGame, notify }) {

    const [game, setGame] = useState(initialGame);
    const isAdd = initialGame.id === 0;

    function handleChange(evt) {
        const clone = { ...game };
        clone[evt.target.name] = evt.target.value;
        setGame(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = isAdd ? "http://localhost:8080/game" : `http://localhost:8080/game/${game.id}`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 204;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(game)
        };

        fetch(url, init)
            .then(response => {
                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return game;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                game: result
            }))
            .catch(error => notify({ error: error }));

    }

    
    return (
        <>
            <h1>{game.id > 0 ? "Edit" : "Add"} Game</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="artist">Artist</label>
                    <input type="text" id="artist" name="artist"
                        className="form-control"
                        value={game.esrbRating} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="album">Album</label>
                    <input type="text" id="album" name="album"
                        className="form-control"
                        value={game.title} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="year">Year</label>
                    <input type="text" id="year" name="year"
                        className="form-control"
                        value={game.description} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="year">Year</label>
                    <input type="text" id="year" name="year"
                        className="form-control"
                        value={game.price} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="year">Year</label>
                    <input type="text" id="year" name="year"
                        className="form-control"
                        value={game.studio} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="year">Year</label>
                    <input type="text" id="year" name="year"
                        className="form-control"
                        value={game.quantity} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default GameForm;