function TshirtCard({ tshirts, notify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/tshirts/${tshirts.id}`, {method:"DELETE"})
        .then(()=>notify({action:"delete",tshirt:tshirts}))
        .catch(error=>notify({action:"delete", error:error}))
    }

    return (
        <tr key={tshirts.id}>
    
            <td>{tshirts.size}</td>
            <td>{tshirts.color}</td>
            <td>{tshirts.description}</td>
            <td>{tshirts.price}</td>
            <td>{tshirts.quantity}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", tshirt: tshirts })}>Edit</button>
            </td>
        </tr>
    );
}

export default TshirtCard;
