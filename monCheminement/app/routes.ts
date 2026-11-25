import { type RouteConfig, route, index } from "@react-router/dev/routes";

export default [
    index("./routes/home.jsx"),
    route("profile", "./components/profile/profile.jsx", [
        index("./components/profile/configuration.jsx"),
        route("addTranscript", "./components/profile/addTranscript.jsx"),
        route("dashboard", "./components/profile/dashboard.jsx")
    ])
] satisfies RouteConfig;
