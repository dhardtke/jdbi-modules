package jdbi_modules.base;

import org.jdbi.v3.core.statement.Query;

/**
 * @since 14.04.2018
 */
public final class Binding extends QueryModifier<Object> {
    /**
     * @param name  the name of the binding
     * @param value the value of the binding
     */
    public Binding(final String name, final Object value) {
        super(name, value);
    }

    @Override
    public String getInSql() {
        return ':' + getName();
    }

    @Override
    public void apply(final Query query, final String newName) {
        query.bind(newName, getValue());
    }
}
