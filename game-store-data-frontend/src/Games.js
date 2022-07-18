import { useState, useEffect } from 'react';

import GameCard from './GameCard.js';
import GameForm from './GameForm.js';

function Games() {

    const [games, setGames] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [scopedGame, setScopedGame] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/game")
            .then(response => response.json())
            .then(result => setGames(result))
            .catch(console.log)
    }, []);
    function addClick() {
        const now = new Date()
        
        setScopedGame({ id: 0, esrbRating:"", title:"", description:"", price: 0, studio:"", quantity:2 })
        setShowForm(true);
    }

    function notify({ action, game, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setGames(game.filter(r => r.id !== game.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedGame(game)
                return;
            case "edit":
                setGames(game.map(r => {
                    if (r.id === game.id) {
                        return game
                    }
                    return r

                }))
                break;

            case "add":
                setGames([...games, game])
                break;

            default:
                console.log("called notify with an invalid action")

        }
        setError("")
        setShowForm(false)

    }

    if (showForm) {
        return <GameForm record={scopedGame} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='recordTitle'>Games</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a game</button>
                <table id='games'>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Studio</th>
                        <th>quantity</th>
                        <th>Esrb Rating</th>
                    </tr>
                    <tbody>
                        {games.map(r => <GameCard key={r.id} game={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Games;