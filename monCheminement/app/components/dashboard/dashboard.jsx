import {Outlet} from "react-router";

function Dashboard() {
    return (
        <div className="dashboard-container w-full h-dvh ">

            <div className="dashboard-content flex flex-col w-full h-dvh ">

                <nav class="navigateur-dashboard">
                    <h2>Menu</h2>
                    <ul>
                            <li id="sessions-bouton">Toutes les sessions</li>
                            <li id="planifier-bouton">Planifier</li>
                            <li id="visualiser-bouton">Visualiser</li>
                            <li id="restaurer-bouton">Restaurer</li>
                            <li id="exporter-bouton">Exporter</li>
                            <li id="configurer-bouton">Configurer</li>
                            <li id="fr-en-bouton">FR/EN</li>
                    </ul>
                </nav>

                <main className="flex-1">
                    <Outlet />
                </main>

                {/* Il me reste a faire les differentes sections du dashboard */}

            </div>


        </div>
    );
}

export default Dashboard;