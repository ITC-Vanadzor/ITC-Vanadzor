# ընտրում ենք ապրանքներ կոնկրետ գների սահմաններում
SELECT * FROM monitor where price between 40000 and 46000;

# ընտրում ենք բոլոր ապրանքների արտադրող ընկերությունների անունները
SELECT company FROM ram union all select company from hdd union all select company from monitor union all select company from mainboard;

# տարատեսակ ապրանքները դասավոում ենք ըստ գնի
SELECT company,model,price FROM monitor union all select company,model,price from ram union all select company, model, price from hdd order by price;

#ընտրում ենք այն մոդելները, որոնցից մնացել  է մեկական հատ
SELECT company,model,price, quantity FROM monitor where quantity=1 union all select company,model,price,quantity from ram where quantity=1 union all select company, model, price,quantity from hdd where quantity=1;

# ընտրում ենք սյուներ տարբեր աղյուսակներից
# ընտրում ենք վաճառված ապրանքները ըստ ամսաթվի աճման
select hdd.id_hdd,hdd.company, hdd.model, hdd.price, sold_hdd.date from hdd inner join sold_hdd on sold_hdd.id_hdd=hdd.id_hdd order by date;

#
