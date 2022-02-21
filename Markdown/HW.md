# Quản lý film

## Tạo bảng director

```roomsql
create table director(
    id int PRIMARY KEY NOT NULL,
    name text,
    avatar text,
    description text
)
```

## Tạo bảng category

```roomsql
create table category(
    id int primary key not null,
    name text
)
```

## Tạo bảng actor

```roomsql
create table actor(
    id int primary key not null,
    last_name text,
    first_name text,
    avatar text
)
```


![img_1.png](img_1.png)


