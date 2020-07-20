import requests
from bs4 import BeautifulSoup as bs
import pymysql as my


def teamDataUpdate(m):
    #connect 생성
    conn=my.connect(host='umj7-015.cafe24.com',user='desert8304',password='rnfhrnrlfjrl6',db='desert8304',charset='utf8')
    cur=conn.cursor(my.cursors.DictCursor)

    #쿼리문 작성
    sql1='update teamRecord set ascore=%s, bscore=%s where gdate=%s and (ateamname=%s and bteamname=%s)'

    url="https://sports.news.naver.com/kbaseball/schedule/index.nhn?date=20200701&month="+str(m)+"&year=2020&teamCode="
    data=requests.get(url)
    dom=bs(data.text,'html.parser')
    #print(dom)
    div=dom.find('div',{'class':'tb_wrap'})  #경기일정 박스 추출
    #print(div)
    divs=div.find_all('div')                 #일일단위로 분류
    #print(divs[1])

    gdate=''
    gtime=''
    ateamname=''
    ascore=''
    bteamname=''
    bscore=''
    stadium=''
    temp=''

    #trs의 길이가 1이상이여야 한다.
    #trs[0]에서는 날짜도 추출해야 한다.
    #경기가 취소되었을 경우 tds의 길이가 기존보다 1이 적다. stadium 값위치 변경됨.

    with open('gameSchedule.csv','w',encoding='utf-8') as f:
        for i in range(len(divs)):
            trs = divs[i].find_all('tr')
            if len(trs)>0:                     #trs 길이가 1이상이여야 날짜 정보가 들어간다. #첫번째 trs에 날짜정보가 들어있다.
                tds=trs[0].find_all('td')
                temp=tds[0].text.strip()
                gdate='2020-'+temp[:temp.find('.')] + '-' + temp[temp.find('.') + 1:-4]
                if len(tds)<4:
                  gtime=tds[2].text.strip()
                  ateamname = '경기없음'
                  bteamname = '경기없음'
                  stadium = '경기없음'
                elif '취소' in tds[3].text:
                    gtime=tds[1].text.strip()
                    temp = tds[2].text.strip().split('\n')
                    ateamname = temp[0]
                    bteamname = temp[4]
                    ascore='-1'
                    bscore='-1'
                    stadium=tds[4].find('span').text.strip()
                else:
                    gtime=tds[1].text.strip()
                    temp=tds[2].text.strip().split('\n')
                    ateamname=temp[0]
                    bteamname=temp[4]
                    if ':' in temp[2] :
                        ascore=temp[2][:temp[2].find(':')]
                        bscore=temp[2][temp[2].find(':')+1:]
                    else:
                        ascore=temp[1]
                        bscore=''
                    stadium=tds[5].find('span').text.strip()

                result = gdate + ',' + gtime + ',' + ateamname + ',' + ascore + ' ' + bscore + ',' + bteamname + ',' + stadium + '\n'
                print(result)
                f.write(result)
                #데이터 삽입
                #cur.execute(sql, (gdate, gtime, ateamname, ascore, bteamname, bscore, stadium))
                for j in range(1,len(trs)):
                    tds=trs[j].find_all('td')    #tds 길이가 6이면 날짜 정보가 들어있다. 그외에는 길이가 5    7 6 3
                    if '취소' in tds[2].text:
                        gtime = tds[0].text.strip()
                        temp = tds[1].text.strip().split('\n')
                        ateamname = temp[0]
                        bteamname = temp[4]
                        ascore='-1'
                        bscore='-1'
                        stadium = tds[3].find('span').text.strip()
                    else:
                        gtime = tds[0].text.strip()
                        temp = tds[1].text.strip().split('\n')
                        ateamname = temp[0]
                        bteamname = temp[4]
                        if ':' in temp[2]:
                            ascore = temp[2][:temp[2].find(':')]
                            bscore = temp[2][temp[2].find(':') + 1:]
                        else:
                            ascore = temp[1]
                            bscore = ''
                        stadium = tds[4].find('span').text.strip()
                    result = gdate + ',' + gtime + ',' + ateamname + ',' +ascore+', '+bscore+','+ bteamname + ',' + stadium + '\n'
                    print(result)
                    f.write(result)
                    # 데이터 삽입
                    cur.execute(sql1, (ascore, bscore, gdate, ateamname, bteamname))
    #commit
    conn.commit()
    conn.close()