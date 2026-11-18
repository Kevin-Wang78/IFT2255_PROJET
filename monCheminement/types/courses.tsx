
type Program = {
    id: string;
    desc: string
}

interface DataProgram {
  id: string;
  name: string;
}

interface DataDepartment {
  programs: DataProgram[];
}

interface DataFaculty {
  departments: DataDepartment[];
}

