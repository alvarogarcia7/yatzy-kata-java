package com.dodevjutsu.kata.yatzee;

public class Roll {
    private final Die die;
    private final int side;

    public Roll(Die die, int side) {
        this.die = die;
        this.side = side;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Roll{");
        sb.append("die=").append(die);
        sb.append(", side=").append(side);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roll roll = (Roll) o;

        if (side != roll.side) return false;
        return die == roll.die;

    }

    @Override
    public int hashCode() {
        int result = die != null ? die.hashCode() : 0;
        result = 31 * result + side;
        return result;
    }

    public Die die() {
        return die;
    }

    public String asString() {
        return String.format("%s:%d", die.asString(), side);
    }
}
