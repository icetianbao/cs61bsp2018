public class NBody{
    public NBody(){
    }
    public static double  readRadius(String file){
        In in = new In(file);
        int firstint = in.readInt();
        double seconditemfile = in.readDouble();
        return seconditemfile;
    }
    public static Planet[] readPlanets(String file){
        In in = new In(file);
        int firstitemfile = in.readInt();
        double seconditemfile = in.readDouble();
        Planet[] planets = new Planet[firstitemfile];
        for(int i = 0;i <= (firstitemfile-1);i++){
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double time = 0;
        String filename = args[2];
        double universeRadus = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        StdDraw.setScale(-universeRadus,universeRadus);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for(int i =0;i<= planets.length-1;i++){
            planets[i].draw();
        }
        while (time != T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i =0;i<= planets.length-1;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0;i<= planets.length-1;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(int i =0;i<= planets.length-1;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time +=dt;
        }

}
}