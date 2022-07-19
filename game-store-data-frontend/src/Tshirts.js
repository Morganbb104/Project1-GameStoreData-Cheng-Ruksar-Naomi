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
    function sizeClick(event) {
        if(event.target.value===""){
            setTshirts([])
        }else{

        fetch(`http://localhost:8080/tshirts/size/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setTshirts(result))
        .catch(error=>console.log(error, "There was an error for your sizes"))
        }

    }
    function colorClick(event) {
        if(event.target.value===""){
            setTshirts([])
        }else{

        fetch(`http://localhost:8080/tshirts/color/${event.target.value}`)
        .then((response)=>response.json())
        .then(result=>setTshirts(result))
        .catch(error=>console.log(error, "There was an error for your colors"))
        }

    }



    function notify({ action, tshirt, error }) {
        if (error) {
            setError(error);
            setShowForm(false);
            return;
        }
        switch (action) {
            case "delete":
                setTshirts(tshirts.filter(r => r.id !== tshirt.id))
                break;

            case "edit-form":
                setShowForm(true)
                setScopedTshirt(tshirt)
                return;
            case "edit":
                setTshirts(tshirts.map(r => {
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
                
                <select name="color" className = "btn btn-primary" onChange= {colorClick}>
                <option >Get tshirt by color</option>
                <option value ="green">green</option>
                <option value="blue">blue</option>
                <option value ="red">red</option>

            </select>
            <select name="level" className = "btn btn-primary" onChange= {sizeClick}>
                <option >Get tshirt size</option>
                <option value ="large">Large</option>
                <option value="small">Small</option>
            

            </select>
                <table id='tshirts'>
                    <tr>
                        <th>Size</th>
                        <th>Color</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Quantity</th>
                      
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