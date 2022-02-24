## Bài 1

```sql
select id,title,year_of_publication
from book
where book.year_of_publication < 1900;

select id,title,page_number
from book
where book.page_number<100;

select id,title,page_number
from book
where book.id_publisher in(1)
order by page_number asc
```


## Bài 2
```sql
select avg(rental_rate)
from film
where rating = 'R';

select count(film_id)
from film
where special_features = 'Deleted Scenes';

select film_id,title
from film
where title like '%ACADEMY%'
```