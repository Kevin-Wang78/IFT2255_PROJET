import { useEffect, useState } from "react";

export function Welcome() {
  const apiUrl = import.meta.env.VITE_BASE_URL;
  const [selection, setSelection] = useState("");
  const [programs, setPrograms] = useState([]);

    useEffect(()=> {
      const fetchProgrames = async () => {
        const res = await fetch(
          apiUrl + "/planification/programs"
        )
        if (res.ok) {
          const returnData = await res.json();
          console.log(returnData.length);
          if (returnData.success){
            const progs = returnData.data;
            progs.sort((a, b) => a.id.localeCompare(b.id));
            setPrograms(progs);
          }
        } else {
          setPrograms([]);
        }
      }
      fetchProgrames();
    }, []);
  

  return (
    <>
      <header>
        <h1>Mon cheminement</h1>
        <h2>Première utilisation ?</h2>

        <nav className="introduction flex flex-col justify-content">
          <div>
            <select>
              <option className="text-center">Choisir votre programme</option>
              {programs && programs.map(program => (
                <option key={program.id} value={program.id}>{ program.id + " - " + program.description}</option>
              ))}
            </select>
          </div>
          

{/* 
          
          <button onClick={() => setSelection(selection === "programme" ? "" : "programme")}>
            Choisir votre programme
          </button> */}

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
