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
    function manufacturerClick(event) {
        if(event.target.value===""){
            setConsoles([])
        }else{

        fetch(`http://localhost:8080/consoles/manufacturer/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setConsoles(result))
        .catch(error=>console.log(error, "There was an error for your manufacturer"))
        }

    }

    function notify({ action, console, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setConsoles(consoles.filter(r => r.id !== console.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedConsole(console)
                return;
            case "edit":
                setConsoles(consoles.map(r => {
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
                
                <select name="color" className = "btn btn-primary" onChange= {manufacturerClick}>
                <option >Get console by manufacturer</option>
                <option value ="manufacturer 1">Manufacturer 1</option>
                <option value="manufacturer 2">Manufacturer 2</option>
                <option value ="manufacturer 3">Manufacturer 3</option>

            </select>
         
                <table id='consoles'>
                    <tr>
                        <th>Model</th>
                        <th>Memory Amount</th>
                        <th>Price</th>
                        <th>Processor</th>
                        <th>Quantity</th>
                        <th>Manufacturer</th>
                    </tr>
                    <tbody>
                        {consoles.map(r => <ConsoleCard key={r.id} console={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Consoles;