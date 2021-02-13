package t4j.app.repo;

public enum EnumRoles {
    ADMINISTRATIVO {
        @Override
        public String toString() {
            return "Administrativo";
        }
    },
    COLABORADOR {
        @Override
        public String toString() {
            return "Colaborador";
        }
    },
    GESTOR {
        @Override
        public String toString() {
            return "Gestor";
        }
    },
    FREELANCER {
        @Override
        public String toString() {
            return "Freelancer";
        }
    };

    @Override
    public abstract String toString();
}
