
import { useState } from "react";

const AddTranscript = () => {

    const [cours, setCours] = useState([
        { nomCours: "", codeCours: "", note: "", gpa: "" }
    ]);

    const ajouterCours = () => {
        setCours([
            ...cours,
            { nomCours: "", codeCours: "", note: "", gpa: "" }
        ]);
    };

    const supprimerCours = (indexASupprimer) => {
    setCours(cours.filter((c, index) => index !== indexASupprimer));
    };

    return (
        <>
            <h1 id="add-transcript">
                Entrez votre relevé de notes
            </h1>

            <form>
                <h2>Informations personnelles</h2>

                <label htmlFor="nomPrincipal">Prénom :</label>
                <input type="text" id="nomPrincipal" name="nomPrincipal" />

                <label htmlFor="nomFamille">Nom de famille :</label>
                <input type="text" id="nomFamille" name="nomFamille" />

                <h2>Informations sur les cours</h2>

                {cours.map((c, index) => (
                    <div key={index}>
                        <h3>Cours {index + 1}</h3>

                        <label htmlFor={`nomCours-${index}`}>
                            Nom du cours :
                        </label>
                        <input
                            type="text"
                            id={`nomCours-${index}`}
                        />

                        <label htmlFor={`codeCours-${index}`}>
                            Code du cours :
                        </label>
                        <input
                            type="text"
                            id={`codeCours-${index}`}
                        />

                        <label htmlFor={`note-${index}`}>
                            Résultat (lettre) :
                        </label>
                        <select id={`note-${index}`}>
                            <option value="">Choisir une note</option>
                            <option value="A+">A+</option>
                            <option value="A">A</option>
                            <option value="A-">A-</option>
                            <option value="B+">B+</option>
                            <option value="B">B</option>
                            <option value="B-">B-</option>
                            <option value="C+">C+</option>
                            <option value="C">C</option>
                            <option value="C-">C-</option>
                            <option value="D+">D+</option>
                            <option value="D">D</option>
                            <option value="E">E</option>
                            <option value="F">F</option>
                        </select>

                        <label htmlFor={`gpa-${index}`}>
                            Résultat (GPA) :
                        </label>
                        <input
                            type="number"
                            id={`gpa-${index}`}
                            step="0.10"
                            min="0"
                            max="4.3"
                        />
                    </div>
                ))}

                <button id="bouton-ajouterCours" type="button" onClick={ajouterCours}>
                    + Ajouter un cours
                </button>

                <button type="button" onClick={supprimerCours}>
                    - Supprimer un cours
                </button>

            </form>
        </>
    );
};

export default AddTranscript;
