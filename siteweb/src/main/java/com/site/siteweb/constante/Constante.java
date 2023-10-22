package com.site.siteweb.constante;

public class Constante {

	public Constante() {

	} 
 
	public enum type {
        ACTUALITE {
            public String toString() {
                return "ACTUALITE";
            }
        },
        RAPPORT {
            public String toString() {
                return "RAPPORT";
            }
        },
        PROJET {
            public String toString() {
                return "PROJET REALISER";
            }
        },
        PROJETENCOURS {
            public String toString() {
                return "PROJET EN COURS";
            }
        },
        OFFRE {
            public String toString() {
                return "OFFRES D'EMPLOIS";
            }
        } 
        
        }
   
    
    	public enum roles {
        admin {
            public String toString() {
                return "ADMIN";
            }
        },
        USER {
            public String toString() {
                return "USER";
            }
        } 
    }

    	public enum typeFichier {
        image {
            public String toString() {
                return "IMAGE";
            }
        },
        video {
            public String toString() {
                return "VIDEO";
            }
        },
        doc {
            public String toString() {
                return "DOC";
            }
        }  
    }

    	public enum langue {
        fr {
            public String toString() {
                return "FRANÇAIS";
            }
        },
        en {
            public String toString() {
                return "ENGISH";
            }
        },
        span {
            public String toString() {
                return "ESPAGNOL";
            }
        },
        kisw {
            public String toString() {
                return "KISWAHILI";
            }
        }, 
    }

    	public enum typeMail {
        gmail {
            public String toString() {
                return "IMAGE";
            }
        },
        mailpro {
            public String toString() {
                return "EMAIL PROFESSIONNEL";
            }
        }   
    }

    	public enum travail {
        emploi {
            public String toString() {
                return "EMPLOI";
            }
        },
        benevole {
            public String toString() {
                return "BENEVOLE";
            }
        },
        stage {
            public String toString() {
                return "STAGE";
            }
        } 
    }

}
