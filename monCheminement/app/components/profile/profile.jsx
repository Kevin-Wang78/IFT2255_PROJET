import { Outlet } from "react-router";
import AddTranscript from "~/components/profile/addTranscript.jsx";

export default function Profile() {
    return (
        <div>
            <div>
                put fetch programs here from welcome.jsx  // todo
            </div>
            <div>
                <AddTranscript />
            </div>
        </div>
    );
}