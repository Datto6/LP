public enum Mes{
    janeiro(31),
    fevereiro(28),
    marco(31),
    abril(30),
    maio(31),
    junho(30),
    julho(31),
    agosto(31),
    setembro(30),
    outubro(31),
    novembro(30),
    dezembro(31);

    private int qntd_dias;
    Mes(int qntd_dias){
        this.qntd_dias=qntd_dias;
    }
    public int get_Qntd_dias() {
        return qntd_dias;
    }
}