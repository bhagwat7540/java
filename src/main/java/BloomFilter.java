import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BloomFilter {
    private final BitSet bitset;
    private final int size;

    public BloomFilter(int size) {
        this.size = size;
        this.bitset = new BitSet(size);
        int[] a = new int[5];
    }

    private int hash1(String s) {
        return (s.hashCode())%size;
    }

    private int hash2(String s) {
        return (s.hashCode()*31)%size;
    }

    public void add(String s) {
        int ind1 = hash1(s);
        int ind2 = hash2(s);

        bitset.set(ind1);
        bitset.set(ind2);
    }

    public boolean mightContain(String s) {
        int ind1 = hash1(s);
        int ind2 = hash2(s);

        return bitset.get(ind1) && bitset.get(ind2);
    }
}
