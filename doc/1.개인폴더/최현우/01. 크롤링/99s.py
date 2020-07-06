import pandas as pd
import matplotlib.pyplot as plt
import matplotlib as mlp
import seaborn as sns
import requests
from bs4 import BeautifulSoup

# 한글 폰트 설정
from matplotlib import font_manager,rc
fontname=font_manager.FontProperties(fname='malgun.ttf').get_name()
rc('font',family=fontname)


req = requests.get('https://www.koreabaseball.com/History/Crowd/History.aspx')
soup = BeautifulSoup(req.text, 'html.parser')

# class 이름이 tData인 table을 가져옵니다
tdata = soup.find('table', {'class':'tData'})

# table에서 tbody를 찾습니다
series = tdata.find('tbody')

# 객체가 아닌 string 형태로 담아줍니다
kbdata_spec = series.text


# tr 태그를 찾습니다.
table_rows = tdata.find_all('tr')

# res라는 list에 row 별로 담아줍니다
res = []
for tr in table_rows:
    td = tr.find_all('td')
    row = [tr.text.strip() for tr in td ]
    if row:
        res.append(row)

# DataFrame으로 만들어 줍니다
df = pd.DataFrame(res, columns=["year", "samsung", "kia", "lotte", "lg", 'doosan', 'hanhwa', 'sk', 'kiwoom', 'nc', 'kt', 'hyeondae', 'ssang' , 'total'])


# 콤마 제거
df['samsung'] = df['samsung'].str.replace(',', '')
df['kia'] = df['kia'].str.replace(',', '')
df['lotte'] = df['lotte'].str.replace(',', '')
df['lg'] = df['lg'].str.replace(',', '')
df['doosan'] = df['doosan'].str.replace(',', '')
df['hanhwa'] = df['hanhwa'].str.replace(',', '')
df['sk'] = df['sk'].str.replace(',', '')
df['kiwoom'] = df['kiwoom'].str.replace(',', '')
df['nc'] = df['nc'].str.replace(',', '')
df['kt'] = df['kt'].str.replace(',', '')
df['hyeondae'] = df['hyeondae'].str.replace(',', '')
df['ssang'] = df['ssang'].str.replace(',', '')
df['total'] = df['total'].str.replace(',', '')


# 데이터 제거 (괄호 포함 데이터 제거)
df['samsung'] = df['samsung'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['kia'] = df['kia'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['lotte'] = df['lotte'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['lg'] = df['lg'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['doosan'] = df['doosan'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['hanhwa'] = df['hanhwa'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['sk'] = df['sk'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['kiwoom'] = df['kiwoom'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['nc'] = df['nc'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['kt'] = df['kt'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['hyeondae'] = df['hyeondae'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['ssang'] = df['ssang'].str.replace(r"\s*\([^()]*\)","").str.strip()
df['total'] = df['total'].str.replace(r"\s*\([^()]*\)","").str.strip()

# datetime type으로 변환
df['year'] = pd.to_datetime(df['year'])

# 날짜 column을 분리
df['year'] = df['year'].dt.year

print(df)

#삼성 연도별 관객수
x = df.groupby('year')['samsung'].sum().keys()
y = df.groupby('year')['samsung'].sum()
sns.barplot(x, y)
plt.xlabel('연도')
plt.ylabel('관객수')
plt.show()