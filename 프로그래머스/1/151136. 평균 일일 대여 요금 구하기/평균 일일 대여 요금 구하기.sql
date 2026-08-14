-- 코드를 입력하세요
select round(avg(daily_fee)) as AVERAGE_FEE from CAR_RENTAL_COMPANY_CAR
where car_type = "SUV";