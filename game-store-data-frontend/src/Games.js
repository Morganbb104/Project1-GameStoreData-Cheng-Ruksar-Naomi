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
        
        setScopedGame({ id: 0, esrbRating:"", title:"", description:"", price: 0, studio:"", quantity:0 })
        setShowForm(true);
    }
    function esrbRatingClick(event) {
        if(event.target.value===""){
            setGames([])
        }else{

        fetch(`http://localhost:8080/game/esrbRating/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setGames(result))
        .catch(error=>console.log(error, "There was an error for your esrb rating"))
        }

    }
    function studioClick(event) {
        if(event.target.value===""){
            setGames([])
        }else{

        fetch(`http://localhost:8080/game/studio/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setGames(result))
        .catch(error=>console.log(error, "There was an error for your studio"))
        }

    } function titleClick(event) {
        if(event.target.value===""){
            setGames([])
        }else{

        fetch(`http://localhost:8080/game/title/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setGames(result))
        .catch(error=>console.log(error, "There was an error for your title"))
        }

    }

    function notify({ action, game, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setGames(games.filter(r => r.id !== game.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedGame(game)
                return;
            case "edit":
                setGames(games.map(r => {
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
        return <GameForm game={scopedGame} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='gameTitle'>Games</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a game</button>
                
                <select name="esrbRating" className = "btn btn-primary" onChange= {esrbRatingClick}>
                <option >Get game by esrb rating</option>
                <option value ="not for children">not for children</option>
                <option value="explicit">explicit</option>
                <option value ="everyone">everyone</option>

            </select>
            <select name="studio" className = "btn btn-primary" onChange= {studioClick}>
                <option >Get game by studio</option>
                <option value ="nintendo">nintendo</option>
                <option value="atari">atari</option>
                <option value="play station">play station</option>
            

            </select>
            <select name="title" className = "btn btn-primary" onChange= {titleClick}>
                <option >Get game by title</option>
                <option value ="spiro">spiro</option>
                <option value="star war">star war</option>
                <option value="avatar">avatar</option>
            

            </select>
                <table id='games'>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Studio</th>
                        <th>Quantity</th>
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