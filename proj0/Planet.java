class Planet{
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    public static final double G = 6.67e-11;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p2){
        return Math.sqrt((this.xxPos - p2.xxPos) * (this.xxPos - p2.xxPos) + (this.yyPos - p2.yyPos) * (this.yyPos - p2.yyPos));
    }
    public double calcForceExertedBy(Planet p2){
        return (G*(this.mass* p2.mass) / (this.calcDistance(p2)*this.calcDistance(p2)));
    }
    public double calcForceExertedByX(Planet p2){
        return (calcForceExertedBy(p2)*(p2.xxPos - this.xxPos)/calcDistance(p2));
    }
    public double calcForceExertedByY(Planet p2){
        return (calcForceExertedBy(p2)*(p2.yyPos - this.yyPos)/calcDistance(p2));
    }
    public double calcNetForceExertedByX(Planet[] allPlanet){
        double sumX =0;
        for (int i = 0; i<=(allPlanet.length-1);i++){
            if(allPlanet[i].equals(this)){
                continue;
            }
            sumX +=calcForceExertedByX(allPlanet[i]);
        }
        return sumX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanet){
        double sumY =0;
        for(int i = 0;i<=(allPlanet.length-1);i++){
            if(this.equals(allPlanet[i])){
                continue;
            }
            sumY +=calcForceExertedByY(allPlanet[i]);
        }
        return sumY;
    }
    public void update(double dt,double fx,double fy){
        double aX = fx/this.mass;
        double aY = fy/this.mass;
        this.xxVel += aX*dt;
        this.yyVel += aY*dt;
        this.xxPos += this.xxVel*dt;
        this.yyPos += this.yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}