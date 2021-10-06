public class Player {

    private int _HP;
    private int _STAMINA;
    private int _ARMOR;
    private int _STR;
    private int _DEX;
    private int _VIT;
    private int _LVL;
    private double _maxXP;
    private double _RES;
    private int _currXP;

    private int posX;
    private int posY;

    //Coordonatele playerului pe harta


    //region Set/Get

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void setPosx(int posX) {
        this.posX = posX;
    }

    public void setPosy(int posY) {
        this.posY = posY;
    }

    public void set_currXP(int currXP) {
        this._currXP = currXP;
    }

    public void set_RES(double RES) {
        this._RES = RES;
    }

    public void set_ARMOR(int ARMOR) {
        this._ARMOR = ARMOR;
    }

    public void set_DEX(int DEX) {
        this._DEX = DEX;
    }

    public void set_HP(int HP) {
        this._HP += HP;
    }

    public void set_maxXP(double maxXP) {
        this._maxXP = maxXP;
    }

    public void set_STAMINA(int STAMINA) {
        this._STAMINA = STAMINA;
    }

    public void set_STR(int STR) {
        this._STR = STR;
    }

    public void set_VIT(int VIT) {
        this._VIT = VIT;
    }

    public void set_LVL(int LVL) {
        this._LVL = LVL;
    }

    public double get_maxXP() {
        return _maxXP;
    }

    public int get_ARMOR() {
        return _ARMOR;
    }

    public int get_DEX() {
        return _DEX;
    }

    public int get_HP() {
        return _HP;
    }

    public int get_STAMINA() {
        return _STAMINA;
    }

    public int get_STR() {
        return _STR;
    }

    public int get_VIT() {
        return _VIT;
    }

    public int get_LVL() {
        return _LVL;
    }

    public double get_RES() {
        return _RES;
    }

    public int get_currXP() {
        return _currXP;
    }
    //endregion

    public Player(){
        set_HP(150);
        set_STAMINA(100);
        set_ARMOR(15);
        set_LVL(1);
        set_STR(14);
        set_DEX(10);
        set_VIT(13);
        set_maxXP(200);
        set_currXP(0);
        set_RES((double)(100 / (100 + get_ARMOR())) );
    }
    public Player(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        _HP = 100;
    }
}
