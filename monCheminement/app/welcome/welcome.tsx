import { useState } from "react";

export function Welcome() {

  const [selection, setSelection] = useState("");

  return (
    <>
      <header>
        <h1>Mon cheminement</h1>
        <h2>Première utilisation ?</h2>

        <nav className="introduction">

          <button onClick={() => setSelection(selection === "programme" ? "" : "programme")}>
            Choisir votre programme
          </button>

          {selection === "programme" && (
            <div className="donnees">
              <p>Informatique</p>
              <p>Mathématiques et informatique</p>
              <p>Mathématiques</p>
            </div>
          )}

          <button onClick={() => setSelection(selection === "anneeAdmission" ? "" : "anneeAdmission")}>
            Année d'admission
          </button>

          {selection === "anneeAdmission" && (
            <div className="donnees">
              <p>2024</p>
              <p>2025</p>
              <p>2026</p>
            </div>
          )}

          <button onClick={() => setSelection(selection === "releveNotes" ? "" : "releveNotes")}>
            Entrez votre relevé de notes
          </button>

          {selection === "releveNotes" && (
            <div className="donnees">
              <p>Entrer vos notes manuellement.</p>
            </div>
          )}

          <span> OU </span>

          <button onClick={() => setSelection(selection === "televersement" ? "" : "televersement")}>
            Téléverser votre relevé de notes
          </button>

          {selection === "televersement" && (
            <div className="donnees">
              <p>Sélectionner un fichier à téléverser.</p>
            </div>
          )}

        </nav>
      </header>
    </>
  );
}
