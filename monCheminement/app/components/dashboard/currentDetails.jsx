import CurrentSemester from "~/components/dashboard/currentSemester.jsx";
import DetailOfBlocks from "~/components/dashboard/detailOfBlocks.jsx";

export default function CurrentDetails () {
    return (
        <div className="flex flex-col h-full gap-y-4 test-border">
            <div className="h-auto test-border">
                <CurrentSemester />
            </div>

            <div className="flex-1 h-full test-border">
                <DetailOfBlocks/>
            </div>
        </div>
    )
}