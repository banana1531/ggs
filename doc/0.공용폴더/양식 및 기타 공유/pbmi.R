#정제된 데이터 데이터 프레임에 넣기
install.packages("readr")
#투수
library(readr)
rawData <- read_csv("./data/ptusu1.csv")
df <- as.data.frame(rawData)
View(df)
#타자
library(readr)
rawData <- read_csv("./data/ptaja1.csv")
df1 <- as.data.frame(rawData)
View(df1)

#BMI와 야구 성적간의 상관관계 분석
#투수
mcor<-cor(df)
round(mcor, 2)

library(corrplot)
corrplot(mcor, method='shade', shade.col=NA, tl.col='black', tl.srt=45)
#타자
mcor1<-cor(df1)
round(mcor1, 2)

library(corrplot)
corrplot(mcor1, method='shade', shade.col=NA, tl.col='black', tl.srt=45)

#BMI(독립)와 야구 성적(종속)간의 회귀 분석
#투수
df<-read.csv("./data/ptusu1.csv")
cor.test(df$bmi,df$era) #상관관계에 대한 유의성 검정
LM<-lm(df$era~df$bmi,data=df)
summary(LM)
plot(LM,col="red",cex=2.5)
abline(LM,col="blue")

#타자
df1<-read.csv("./data/ptaja1.csv")
cor.test(df1$bmi,df1$tayul) #상관관계에 대한 유의성 검정
L1<-lm(df1$tayul~df1$bmi,data=df1)
summary(L1)
plot(L1,col="red",cex=2.5)
abline(L1,col="blue")

#의사결정 나무
install.packages('rpart')
install.packages('rpart.plot')
library(rpart)
library(rpart.plot)

#투수
data<-read.csv('./data/ptusu1.csv')
t2=rpart(data$era~.,data=data)
rpart.plot(t2,cex=1)
#타자
data1<-read.csv('./data/ptaja1.csv')
t1=rpart(data1$tayul~.,data=data1)
rpart.plot(t1,cex=1)



