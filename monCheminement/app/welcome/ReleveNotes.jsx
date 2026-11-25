
import { useState } from "react";

function ReleveNotes() {
    const [cours, setCours] = useState([
        { code: "", nom: "", credits: "", note: "", session: "" }
    ]);

    function modifierCours(index, champ, valeur) {
        const nouveauCours = [...cours];

        nouveauCours[index] = {
            ...nouveauCours[index],
            [champ]: valeur
        };

        setCours(nouveauCours);
    }

    function ajouterCours() {
        setCours([
            ...cours,
            { code: "", nom: "", credits: "", note: "", session: "" }
        ]);
    }

    function supprimerCours(index) {
        setCours(cours.filter((_, i) => i !== index));
    }

    function soumettre(e) {
        e.preventDefault();

        if (cours.length === 0) {
            alert("Ajoutez au moins un cours.");
            return;
        }

        if (cours.some(c => c.code.trim().toUpperCase() === "MAT1000")) {
            alert("MAT1000 n'est pas autorisé.");
            return;
        }

        console.log("Relevé de notes :", cours);
        alert("Relevé de notes enregistré !");
    }

    return (
        <form onSubmit={soumettre}>

            <h2>Mon relevé de notes</h2>

            {cours.map((c, index) => (
                <div className="donnees" key={index}>

                    <h3>Cours {index + 1}</h3>

                    <label>Code du cours :</label>
                    <input
                        type="text"
                        value={c.code}
                        onChange={e => modifierCours(index, "code", e.target.value)}
                        required
                    />

                    <label>Nom du cours :</label>
                    <input
                        type="text"
                        value={c.nom}
                        onChange={e => modifierCours(index, "nom", e.target.value)}
                        required
                    />

                    <label>Crédits :</label>
                    <input
                        type="number"
                        min="1"
                        step="1"
                        value={c.credits}
                        onChange={e => modifierCours(index, "credits", e.target.value)}
                        required
                    />

                    <label>Note obtenue :</label>
                    <input
                        type="number"
                        min="0"
                        max="100"
                        step="0.1"
                        value={c.note}
                        onChange={e => modifierCours(index, "note", e.target.value)}
                        required
                    />

                    <label>Session :</label>
                    <select
                        value={c.session}
                        onChange={e => modifierCours(index, "session", e.target.value)}
                        required
                    >
                        <option value="">Choisir une session</option>
                        <option value="Automne">Automne</option>
                        <option value="Hiver">Hiver</option>
                        <option value="Été">Été</option>
                    </select>

                    {cours.length > 1 && (
                        <button
                            type="button"
                            onClick={() => supprimerCours(index)}
                        >
                            Supprimer ce cours
                        </button>
                    )}

                </div>
            ))}

            <button type="button" onClick={ajouterCours}>
                + Ajouter un cours
            </button>

            <button type="submit">
                Enregistrer mon relevé
            </button>

        </form>
    );
}

export default ReleveNotes;