package com.vsolv.appframework.cqrs.query;

public interface QueryHandler<Q extends Query, R extends QueryResult> {
    public R execute(Q query);
}
