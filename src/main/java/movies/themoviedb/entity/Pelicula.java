package movies.themoviedb.entity;

public class Pelicula {
    private Description description;

    public static class Description {
        private String title;
        private String year;
        private String actors;
        private String img_poster;

        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getActors() {
            return actors;
        }

        public String getImg_Poster() {
            return img_poster;
        }
    }

    public Description getDescription() {
        return description;
    }
}
