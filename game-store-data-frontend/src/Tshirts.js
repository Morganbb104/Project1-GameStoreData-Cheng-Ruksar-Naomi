import { useState, useEffect } from 'react';

import TshirtCard from './TshirtCard.js';
import TshirtForm from './TshirtForm.js';

function Tshirts() {

    const [tshirts, setTshirts] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [scopedTshirt, setScopedTshirt] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/tshirts")
            .then(response => response.json())
            .then(result => setTshirts(result))
            .catch(console.log)
    }, []);
    function addClick() {
        const now = new Date()

        setScopedTshirt({ id: 0, size:"", color:"", description:"", price: 0, quantity:2 })
        setShowForm(true);
    }

    function notify({ action, tshirt, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setTshirts(tshirt.filter(r => r.id !== tshirt.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedTshirt(tshirt)
                return;
            case "edit":
                setTshirts(tshirt.map(r => {
                    if (r.id === tshirt.id) {
                        return tshirt
                    }
                    return r

                }))
                break;

            case "add":
                setTshirts([...tshirts, tshirt])
                break;

            default:
                console.log("called notify with an invalid action")

        }
        setError("")
        setShowForm(false)

    }

    if (showForm) {
        return <TshirtForm tshirt={scopedTshirt} notify={notify} />
    }

    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='tshirtTitle'>Tshirt</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Add a tshirt</button>
                <table id='tshirts'>
                    <tr>
                        <th>Size</th>
                        <th>Color</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>quantity</th>
                      
                    </tr>
                    <tbody>
                        {tshirts.map(r => <TshirtCard key={r.id} tshirt={r} notify={notify} />)}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Tshirts;