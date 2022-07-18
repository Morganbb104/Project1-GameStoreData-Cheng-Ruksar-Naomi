import { useState, useEffect } from 'react';

import ConsoleCard from './ConsoleCard.js';
import ConsoleForm from './ConsoleForm.js';

function Consoles() {

    const [consoles, setConsoles] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [scopedConsole, setScopedConsole] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/consoles")
            .then(response => response.json())
            .then(result => setConsoles(result))
            .catch(console.log)
    }, []);
    function addClick() {
        const now = new Date()
 
        setScopedConsole({ id: 0, model:"", memoryAmount:"", processor:"", price: 0, manufacturer:"", quantity:0 })
        setShowForm(true);
    }

    function notify({ action, console, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setConsoles(console.filter(r => r.id !== console.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedConsole(console)
                return;
            case "edit":
                setConsoles(console.map(r => {
                    if (r.id === console.id) {
                        return console
                    }
                    return r

                }))
                break;

            case "add":
                setConsoles([...consoles, console])
                break;

            default:
                console.log("called notify with an invalid action")

        }
        setError("")
        setShowForm(false)

    }

    if (showForm) {
        return <ConsoleForm console={scopedConsole} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='consoleTitle'>Consoles</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a console</button>
                <table id='consoles'>
                    <tr>
                        <th>Model</th>
                        <th>Memory Amount</th>
                        <th>Price</th>
                        <th>processor</th>
                        <th>quantity</th>
                        <th>manufacturer</th>
                    </tr>
                    <tbody>
                        {consoles.map(r => <ConsoleCard key={r.id} game={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Consoles;