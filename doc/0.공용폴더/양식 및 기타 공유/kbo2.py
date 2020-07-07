#pkbo.csv 의 생일(포맷 yyyy-MM-dd 로 변경) , 이름 정보를 이용하여 선수 경기기록을 가져오자
#2020년 날짜별 기록 가져오기
#총 280명 되어야함
#url = http://www.statiz.co.kr/player.php?opt=3&name=%EB%B0%95%EC%9A%A9%ED%83%9D&birth=1979-04-21

import time
import pandas as pd
import datetime as dt

#데이터 정제 ---------------------------------
# data=pd.read_csv('data\\pkbo2.csv',header=None)
# # print(data)
# # print(data.info())
# # data[10]=pd.to_datetime(data[2]) # Unknown string format 에러
# #----------------------------------
# data[10]=data[2].str.split('일')
#
# pbd=[]
# for i in range(0,280):
#     pbd=data[10][i][0]
#     data.iloc[i,10]=pbd
# print(data)
# data.to_csv('data\\pkbo3.csv',index=False,header=False)
#----------------------------------------------------------------
#URL 정제
# data=pd.read_csv('data\\pkbo3.csv',header=None)
# # with open('data\\pkbo3.csv','a',encoding='utf-8')as f:
# #     driver = webdriver.Chrome('../pj4/chromedriver.exe')
# for i in range(0,280):
#     cnt=[i]
#     pname=data.iloc[i,0]
#     # print(pname)
#     # print(type(pname))
#     url = 'http://www.statiz.co.kr/player.php?opt=3&name=' + pname
#     # print(url)
#     for i2 in cnt:
#         pbd=data.iloc[i2,10]
#         # print(pbd)
#         # print(type(pbd))
#         url = url+'&birth='+pbd
#     print(url)
#--------------------------------------------


import requests
from bs4 import BeautifulSoup
#총 280명 중 2명(김태훈, 정도운)제외
#투수
# data=pd.read_csv('data\\pkbo3.csv',header=None)
# with open('data\\pkbot.csv', 'a', encoding='utf-8')as f:
#         for i in range(0,280):
#             cnt=[i]
#             pname=data.iloc[i,0]
#             # print(pname)
#             # print(type(pname))
#             url = 'http://www.statiz.co.kr/player.php?opt=3&name=' + pname
#             # print(url)
#             for i2 in cnt:
#                 pbd=data.iloc[i2,10]
#                 # print(pbd)
#                 # print(type(pbd))
#                 url = url+'&birth='+pbd
#             # print(url)
#                 recvd=requests.get(url)
#                 dom=BeautifulSoup(recvd.text,'html.parser')
#                 # print(dom)
#                 div=dom.find('div',{'class':'box-body no-padding table-responsive'})
#                 # print(div)
#                 #oddrow
#                 # divs=div.find_all('tr',{'class':'oddrow_stz0'})
#                 #evenrow
#                 divs = div.find_all('tr', {'class': 'evenrow_stz0'})
#                 # print(divs)
#                 # print(divs)
#                 for div in divs:
#                     # print(div)
#                     spans=div.find_all('span')
#                     templist =[]
#                     temp =[]
#                     for span in spans:
#                         # print(span)
#                         # print(span.text)
#                         temp=span.text
#                         templist.append(temp.split('\n'))
#
#                     # print(len(templist))
#                     if len(templist) >=30:
#                         continue
#                     pdate = templist[0][0]
#                     pvs = templist[1][0]
#                     presult = templist[2][0]
#                     psunbal = templist[3][0]
#                     pining = templist[4][0]
#                     psiljum = templist[5][0]
#                     pjachak = templist[6][0]
#                     ptaja = templist[7][0]
#                     ptasu = templist[8][0]
#                     panta = templist[9][0]
#                     peta= templist[10][0]
#                     psamta= templist[11][0]
#                     phomrun= templist[12][0]
#                     pb4= templist[13][0]
#                     pgo4= templist[14][0]
#                     p4gu= templist[15][0]
#                     p3jin= templist[16][0]
#                     ptugu= templist[17][0]
#                     pwhip= templist[18][0]
#                     ptayul= templist[19][0]
#                     pchulu= templist[20][0]
#                     pops= templist[21][0]
#                     pera= templist[22][0]
#                     pavli= templist[23][0]
#                     pre24= templist[24][0]
#                     pwpa= templist[25][0]
#                     pgsc= templist[26][0]
#                     pdec= templist[27][0]
#                     pgan= templist[28][0]
#                     #29개
#                     str1 = '{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}\n'.format(pname,pbd,pdate,pvs,
#                                                                     presult,psunbal,pining,psiljum,pjachak,ptaja,ptasu,panta,
#                                                                     peta,psamta,phomrun,pb4,pgo4,p4gu,p3jin,ptugu,pwhip,ptayul,pchulu,
#                                                                     pops,pera,pavli,pre24,pwpa,pgsc,pdec,pgan
#                     )
#                     print(str1)
#                     f.write(str1)

#타자
data=pd.read_csv('data\\pkbo3.csv',header=None)
with open('data\\pkboj.csv', 'a', encoding='utf-8')as f:
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
                    pdate = templist[0][0]
                    pvs = templist[1][0]
                    presult = templist[2][0]
                    ptasun = templist[3][0]
                    pp = templist[4][0]
                    psunbal = templist[5][0]
                    ptasu = templist[6][0]
                    pdjum = templist[7][0]
                    panta = templist[8][0]
                    peta = templist[9][0]
                    psamta= templist[10][0]
                    phomrun= templist[11][0]
                    pruta= templist[12][0]
                    ptajum= templist[13][0]
                    pdoru= templist[14][0]
                    pdosil= templist[15][0]
                    pb4= templist[16][0]
                    p4gu= templist[17][0]
                    pgo4= templist[18][0]
                    p3jin= templist[19][0]
                    pbsal= templist[20][0]
                    phita= templist[21][0]
                    phibi= templist[22][0]
                    ptayul= templist[23][0]
                    pculu= templist[24][0]
                    pjangta= templist[25][0]
                    pops= templist[26][0]
                    ptugu= templist[27][0]
                    pavli= templist[28][0]
                    pre24= templist[29][0]
                    pwpa = templist[30][0]
                    #31개
                    str1 = '{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{},{}\n'.format(pname,pbd,
                                                                  pdate,pvs, presult,ptasun,pp, psunbal,ptasu, pdjum,panta,peta, psamta,phomrun,
                                                                  pruta, ptajum,pdoru, pdosil, pb4, p4gu, pgo4, p3jin, pbsal, phita, phibi,
                                                                  ptayul,pculu, pjangta, pops,ptugu, pavli, pre24,pwpa)
                    print(str1)
                    f.write(str1)


