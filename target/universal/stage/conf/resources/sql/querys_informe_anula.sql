POR RUBRO
select orr.nombre,sum(ol.total+COALESCE(ola.totalAjuste,0)) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 
o.state_id = 11 and o.state_id = 11 and ej.id= 9
group by orr.nombre
---------------
POR FECHA
select orr.nombre,TO_CHAR(COALESCE(fecha_provision::DATE,fecha_orden::DATE), 'mm-yyyy') as fecha,
--expediente_id,o.id ,
sum(ol.total+COALESCE(ola.totalAjuste,0)) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 

o.state_id = 11 and o.state_id = 11 and ej.id= 9 and  fecha_provision is null-- > '2020-12-31'
group by orr.nombre,TO_CHAR(COALESCE(fecha_provision::DATE,fecha_orden::DATE), 'mm-yyyy')
order by fecha asc
---------------------------

select orr.nombre,TO_CHAR(COALESCE(fecha_provision::DATE,fecha_orden::DATE), 'mm-yyyy') as fecha,
--expediente_id,o.id ,
sum(ol.total+COALESCE(ola.totalAjuste,0)) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 
o.state_id = 11 and o.state_id = 11 and ej.id= 9 and  fecha_provision is null-- > '2020-12-31'
group by orr.nombre,TO_CHAR(COALESCE(fecha_provision::DATE,fecha_orden::DATE), 'mm-yyyy')
order by fecha asc


o.state_id = 11 and o.state_id = 11 and ej.id= 9
--group by orr.nombre,TO_CHAR(fecha_orden::DATE, 'mm-yyyy')
order by fecha_orden asc
---------------------------
POR INSTITUCIOn
select d.nombre,round(sum(ol.total+COALESCE(ola.totalAjuste,0)),2) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join depositos d on d.id = o.deposito_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 
o.state_id = 11 and o.state_id = 11 and ej.id= 9
group by d.nombre
order by total desc
---------------------------
POR INSTITUCION RUBRO
select d.nombre,orr.nombre,round(sum(ol.total+COALESCE(ola.totalAjuste,0)),2) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join depositos d on d.id = o.deposito_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 
o.state_id = 11 and o.state_id = 11 and ej.id= 9
group by orr.nombre,d.nombre
order by orr.nombre,d.nombre

---------------------------
POR  RUBRO INSTITUCION
select orr.nombre,d.nombre,round(sum(ol.total+COALESCE(ola.totalAjuste,0)),2) total --,o.state_id 
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join depositos d on d.id = o.deposito_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total 
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste 
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id	
where --o.id in(81279,81251) and 
o.state_id = 11 and o.state_id = 11 and ej.id= 9
group by orr.nombre,d.nombre
order by orr.nombre,d.nombre
---------------------------
PROTESIS CANTIDAD POR PRODUCTOS
select count(*),  p.nombre,sum(ol.cantidad*ol.precio),sum(c) as c
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join(select count(*) as c,orden_linea_id  as orden_linea_id 
		  from orden_linea_clientes  
		  --inner join clientes c on c.id = oc2.cliente_id
	           --where c.sexo = 'M'
		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id = 6--and o.id = 82867

group by p.nombre--,ol.precio 
order by c desc
--------------------------
TOTALES POR PRECIO PRODUCTOS
select count(*),  p.nombre, (ol.precio) AS hhh,sum(c) as c
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
inner join(select count(*) as c,orden_linea_id  as orden_linea_id 
		  from orden_linea_clientes  
		  --inner join clientes c on c.id = oc2.cliente_id
	           --where c.sexo = 'M'
		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id = 6--and o.id = 82867

group by p.nombre,ol.precio 
order by ol.precio desc
-----------------------------
TOTALES EQUIPOS 
select count(*),  p.nombre, SUM(ol.precio) AS hhh 
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id = 1 --and o.id = 82867
group by p.nombre--,ol.precio 
order by hhh desc
---------------
ESTUDIOS MEDICOS
select count(*),  p.nombre, (ol.precio) AS hhh,sum(c) as c
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
--inner join(select count(*) as c,orden_linea_id  as orden_linea_id 
--		  from orden_linea_clientes  
		  --inner join clientes c on c.id = oc2.cliente_id
	           --where c.sexo = 'M'
--		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id = 2 --and o.id = 82867

group by p.nombre,ol.precio 
order by ol.precio desc
-------------------------
MEDICAMENTOS
select count(*),  p.nombre, (ol.precio) AS hhh--,sum(c) as c
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
--inner join(select count(*) as c,orden_linea_id  as orden_linea_id 
--		  from orden_linea_clientes  
		  --inner join clientes c on c.id = oc2.cliente_id
	           --where c.sexo = 'M'
--		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id = 4 --and o.id = 82867

group by p.nombre,ol.precio 
order by ol.precio desc
-------------------------
SERVICIOS
select count(*),  p.nombre, (ol.precio) AS hhh--,sum(c) as c
from ordenes o 
inner join expedientes e on e.id = o.expediente_id 
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
inner join ordenes_rubros orr on orr.id = o.orden_rubro_id
--inner join(select count(*) as c,orden_linea_id  as orden_linea_id 
--		  from orden_linea_clientes  
		  --inner join clientes c on c.id = oc2.cliente_id
	           --where c.sexo = 'M'
--		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.state_id = 11 and o.state_id = 11 and ej.id= 9 and orr.id =7 --and o.id = 82867

group by p.nombre,ol.precio 
order by ol.precio desc
-----------------------------------------
TOTAL DE OBLIGACIONES POR PERIODO
select p.nombre,sum(total_acta) --, ar.*,ta.* 
from totales_por_acta ta
inner join actas_recepcion ar on ta.acta_id = ar.id
inner join periodos p on p.id = ar.periodo_id
inner join ordenes_provision op on op.id = ta.orden_provision_id 
inner join ordenes oc on oc.id = op.orden_compra_id
inner join expedientes e on e.id = oc.expediente_id
where e.ejercicio_id = 12 and oc.orden_rubro_id = 7
group by p.nombre
order by p.nombre







