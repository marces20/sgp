select count(*) as c, o.orden_rubro_id,orr.nombre,ej.nombre
 
from ordenes o 
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join expedientes e on e.id= o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join 
where state_id =11
group by o.orden_rubro_id,orr.nombre,ej.nombre
order by ej.nombre,o.orden_rubro_id

xxz<xs