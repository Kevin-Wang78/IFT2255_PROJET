import { useEffect, useState } from "react";
import ReleveNotes from "./ReleveNotes";
import { useNavigate } from "react-router";

export function Welcome() {
  const apiUrl = import.meta.env.VITE_BASE_URL;
  const [selection, setSelection] = useState("");
  const [programs, setPrograms] = useState([]);
  const navigate = useNavigate();

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

          <button onClick={() => setSelection(selection === "anneeAdmission" ? "" : "anneeAdmission")}>
            Année d'admission
          </button>

          {selection === "anneeAdmission" && (
            <select id="anneeAdmissions">
            <option value=""> Année d'admission </option>
            <option value="Automne 2027">Automne 2027</option>
            <option value="Hiver 2028">Hiver 2028</option>
            <option value="Ete 2028">Ete 2028</option>
            </select>
          )}

          <button onClick={() => navigate("/profile/addTranscript")}>
            Entrez votre relevé de notes
          </button>

          {selection === "releveNotes" && (
              <div className="releveNote">
                <ReleveNotes />
              </div>
          )}

          <span> OU </span>

          <button onClick={() => setSelection(selection === "televersement" ? "" : "televersement")}>
            Téléverser votre relevé de notes
          </button>

          {selection === "televersement" && (
            <>
            <div class="forme-groupe">
              <label htmlFor="document">Téléversez votre releve de notes</label>
              <input className="forme-telechargement" type="file" id="document" accept=".json"/>
            </div>  
            </>
          )}
  
        </nav>
      </header>
    </>
  );
}
