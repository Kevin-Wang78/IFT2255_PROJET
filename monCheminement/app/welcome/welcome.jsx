import { useEffect, useState } from "react";

export function Welcome() {
  const apiUrl = import.meta.env.VITE_API_BASE_URL;
  const [selection, setSelection] = useState("");
  const [programs, setPrograms] = useState([]);

    useEffect(()=> {
      const fetchProgrames = async () => {
        const res = await fetch(
          apiUrl + "/faculties"
        )
        if (res.ok) {
          // extract list of programes
          const returnData = await res.json();

          let progs = [];
          // convertir les données en type désirable.
          // cette conversion doit être faire dans le server, ici, il est juste un example comment fetch data
          returnData.forEach((faculty) => {
            if (faculty.departments) {
              faculty.departments.forEach((department) => {
                if (department.programs) {
                  department.programs.forEach((program)=>{
                    progs.push({
                      id: program.id,
                      desc: program.name
                    })

                  })
                }
              })
            }
          })

          progs.sort((a, b) => a.id.localeCompare(b.id));
          // set programs
          setPrograms(progs);
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
                <option key={program.id} value={program.id}>{ program.id + " - " + program.desc}</option>
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
