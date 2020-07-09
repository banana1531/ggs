import pymysql as my
import pandas as pd
import requests
from bs4 import BeautifulSoup
#총 280명 중 2명(김태훈, 정도운)제외
#타자 마리아 디비에 데이터 넣기
#1. db 연결
conn= my.connect(host='umj7-015.cafe24.com', user='desert8304',
           password='rnfhrnrlfjrl6', db='desert8304', charset='utf8')

#db 인코딩 utf-8 세팅
conn.query("set character_set_connection=utf8;")
conn.query("set character_set_server=utf8;")
conn.query("set character_set_client=utf8;")
conn.query("set character_set_results=utf8;")
conn.query("set character_set_database=utf8;")

#2. 커서 생성
cur=conn.cursor(my.cursors.DictCursor)
cur2=conn.cursor(my.cursors.DictCursor)
cur3=conn.cursor(my.cursors.DictCursor)
#3-1. select 쿼리문
sql1='select pno,teamName  from playerinfo where name=%s and birth=%s'
sql2='select teamname from teaminfo where teamname=%s'
# 3-2. insert 쿼리문 #31개 타자정보, 3개 선수정보
sql3='''insert into playerRecord (
pno,teamName,ptype,gdate,vs,gresult,sunbal,tasu,anta,eta,
samta,home_run,ball4,go4,sagu,samjin,tugu,tayul,culu,ops,
avli,re24,wpa,tasun,p,djum,ruta,tajum,doru,dosil,
byungsal,hita,hibi,jangta)
values( %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,
        %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,
        %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,
        %s,%s,%s,%s)'''

#데이터 수집
data=pd.read_csv('data\\pkbo3.csv',header=None)

for i in range(0,280):
    cnt=[i]
    pname=data.iloc[i,0]
    # print(pname)
    # print(type(pname))
    url = 'http://www.statiz.co.kr/player.php?opt=3&name=' + pname
    # print(url)
    for i2 in cnt:
        pbd=data.iloc[i2,10]
        # print(pbd)
        # print(type(pbd))
        url = url+'&birth='+pbd
    # print(url)
        recvd=requests.get(url)
        dom=BeautifulSoup(recvd.text,'html.parser')
        # print(dom)
        div=dom.find('div',{'class':'box-body no-padding table-responsive'})
        # print(div)
        #oddrow
        # divs=div.find_all('tr',{'class':'oddrow_stz0'})
        #evenrow
        divs = div.find_all('tr', {'class': 'evenrow_stz0'})
        # print(divs)
        # print(divs)
        for div in divs:
            # print(div)
            spans=div.find_all('span')
            templist =[]
            temp =[]
            for span in spans:
                # print(span)
                # print(span.text)
                temp=span.text
                templist.append(temp.split('\n'))

            # print(len(templist))
            if len(templist) <30 :
                continue
            gdate = templist[0][0]
            vs = templist[1][0]
            gresult = templist[2][0]
            tasun = templist[3][0]
            p = templist[4][0]
            sunbal = templist[5][0]
            tasu = templist[6][0]
            djum = templist[7][0]
            anta = templist[8][0]
            eta = templist[9][0]
            samta= templist[10][0]
            home_run= templist[11][0]
            ruta= templist[12][0]
            tajum= templist[13][0]
            doru= templist[14][0]
            dosil= templist[15][0]
            ball4= templist[16][0]
            sagu= templist[17][0]
            go4= templist[18][0]
            samjin= templist[19][0]
            byungsal= templist[20][0]
            hita= templist[21][0]
            hibi= templist[22][0]
            tayul= templist[23][0]
            culu= templist[24][0]
            jangta= templist[25][0]
            ops= templist[26][0]
            tugu= templist[27][0]
            avli= templist[28][0]
            re24= templist[29][0]
            wpa = templist[30][0]
            #31개
            str1 = '{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}\n'.format(pname,pbd,
                                                          gdate,vs, gresult,tasun,p, sunbal,tasu, djum,anta,eta, samta,home_run,
                                                          ruta, tajum,doru, dosil, ball4, sagu, go4, samjin, byungsal, hita, hibi,
                                                          tayul,culu, jangta, ops,tugu, avli, re24,wpa)
            # print(str1)
            cur.execute(sql1, (pname,pbd,))
            rows = cur.fetchall()
            for row in rows:
                pno = row['pno']
                teamName1 = row['teamName']
                ptype = '타자'
                print(pno,teamName1,ptype)
            cur2.execute(sql2,(teamName1,))
            rows1 = cur2.fetchall()
            for row in rows1:
                teamName = row['teamname']
                print(teamName)
            cur3.execute(sql3, (pno,teamName,ptype,gdate,vs,gresult,sunbal,tasu,anta,eta,samta,
                               home_run,ball4,go4,sagu,samjin,tugu,tayul,culu,ops,avli,re24,wpa,
                               tasun,p,djum,ruta,tajum,doru,dosil,byungsal,hita,hibi,jangta))
            print(str1)
            conn.commit()


conn.close()