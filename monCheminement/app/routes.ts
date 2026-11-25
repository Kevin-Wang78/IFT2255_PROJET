import { type RouteConfig, route, index } from "@react-router/dev/routes";

export default [
    index("./routes/home.jsx"),
    route("profile", "./components/profile/profile.jsx", [
        index("./components/profile/configuration.jsx"),
        route("addTranscript", "./components/profile/addTranscript.jsx"),
    ]),
    route("dashboard", "./components/dashboard/dashboard.jsx", [
        route("", "./components/dashboard/dashboardSummary.jsx", [
            index("./components/dashboard/currentDetails.jsx"),
            route("myPlanification", "./components/planification/myPlanification.jsx"),
        ]),
        route("planification", "./components/planification/planification.jsx")
    ])
] satisfies RouteConfig;
