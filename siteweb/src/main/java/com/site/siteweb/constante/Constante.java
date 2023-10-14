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
            }} 
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
}
