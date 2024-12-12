package mobile.filters;

import java.util.List;

public class NofMFilter<T> implements Filter<T> {
    Integer N;
    Integer M;
    List<Filter<T>> filters;

    public NofMFilter(Integer N, Integer M, List<Filter<T>> filters) {
        this.N = N;
        this.M = M;
        this.filters = filters;
    }

    @Override
    public boolean matches(T item) {
        return filters.stream()
                .filter(f -> f.matches(item))
                .count() >= N;
    }
}
