class Movie implements Comparable<Movie>{
    int movie;
    int price;
    int shop;
    boolean isRented;

    public Movie(int shop,int movie,int price){
        this.movie = movie;
        this.price = price;
        this.shop = shop;
        this.isRented = false;
    }

    public boolean equals(Movie other){
        if(this.movie == other.movie && this.price == other.shop && this.shop == other.shop)
            return true;
        return false;
    }

    public int compareTo(Movie other){
        if(this.price != other.price)return other.price - this.price;

        if(this.shop!=other.shop) return other.shop - this.shop;

        return other.movie - this.movie;
    }

    public void changeStatus(){
        this.isRented = !this.isRented;
    }
}

class MovieRentingSystem {
    Map<Integer,TreeSet<Movie>> movieToMoviesDataMap;
    TreeSet<Movie> rentedMovies;
    List<Map<Integer,Movie>> shopToMoviesMap;


    public MovieRentingSystem(int n, int[][] entries) {
        this.movieToMoviesDataMap = new HashMap<>();
        this.rentedMovies = new TreeSet<>();
        this.shopToMoviesMap = new ArrayList<>();

        for(int i=0;i<n;i++){
            shopToMoviesMap.add(new HashMap<>());
        }

        for(int[] entry : entries){
            int shop = entry[0];
            int movieId = entry[1];
            int price = entry[2];

            Movie movie = new Movie(shop,movieId,price);

            if(!movieToMoviesDataMap.containsKey(movieId)){
                movieToMoviesDataMap.put(movieId,new TreeSet<>());
            }
            movieToMoviesDataMap.get(movieId).add(movie);

            shopToMoviesMap.get(shop).put(movieId,movie);
        }

    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if(!movieToMoviesDataMap.containsKey(movie))return ans;

        TreeSet<Movie> movies = movieToMoviesDataMap.get(movie);

        Iterator<Movie> descItr = movies.descendingIterator();
        
        int count = 0;

        while(descItr.hasNext() && count < 5){
            Movie movieData = descItr.next();

            int movieId = movieData.movie;
            int shop = movieData.shop;
            if(shopToMoviesMap.get(shop).get(movieId).isRented)
                continue;
            count++;
            ans.add(shop);
        }

        return ans;
    }
    
    public void rent(int shop, int movie) {
        Movie toRent = shopToMoviesMap.get(shop).get(movie);
        toRent.changeStatus();
        shopToMoviesMap.get(shop).put(movie,toRent);
        rentedMovies.add(toRent);
    }
    
    public void drop(int shop, int movie) {
        Movie toDrop = shopToMoviesMap.get(shop).get(movie);
        rentedMovies.remove(toDrop);
        toDrop.changeStatus();
        shopToMoviesMap.get(shop).put(movie,toDrop);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();

        Iterator<Movie> descItr = rentedMovies.descendingIterator();

        int count = 0;
        while (descItr.hasNext() && count < 5) {
            count++;
            Movie movie = descItr.next();
            ans.add(Arrays.asList(movie.shop,movie.movie));
        }

        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */