
import Calendar from "~/components/dashboard/calendar.jsx";
import News from "~/components/dashboard/news.jsx";
import {Outlet} from "react-router";
import SummaryOfProgression from "~/components/dashboard/summaryOfProgression.jsx";

export default function DashboardSummary () {
    return (
        <div className="flex flex-row test-border w-full h-full">
            <div className="flex-1 flex flex-col test-border h-full">
                <SummaryOfProgression/>
                <Outlet />
            </div>
            <div className="flex flex-col w-1/5 test-border h-full">
                <Calendar />
                <News />
            </div>
        </div>
    )

}