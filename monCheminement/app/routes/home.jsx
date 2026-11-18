// import  { Route } from "./+types/home";
import { Welcome } from "../welcome/welcome";

export function meta({}) {
  return [
    { title: "Mon cheminement App" },
    { name: "description", content: "Welcome to Mon cheminement!" },
  ];
}

export default function Home() {
  return <Welcome />;
}
