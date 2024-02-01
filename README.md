# ssafy-algorithm-study

## 양식
- 주간 폴더명을 `week01` 형식으로 만들기
- 폴더 내 README파일을 만들고, 문제 및 풀이기간을 명시하기
- 출제 사이트 및 문제 번호로 폴더 만들기 ex) `BOJ_1012`, `SWEA_2806`
> 빈 폴더를 commit하는 방법: 폴더 내에 `.gitkeep` 파일 생성
- 코드 파일명은 `SWEA_2806_박진우.java` 형식으로 하기

## Branch 관리
- 문제 출제자가 주간 폴더, 문제별 폴더 및 README를 작성 시 Main에 바로 작성하기 
- **문제를 풀 때에는, Main에 바로 Commit하지 않고, 자기 Branch에서 하기**
- Branch 이름은 다음과 이름 초성으로 하기 `mhk, jwp, jyb, mhw, smy, hyl`
- 문제를 다 풀었을 때, Main Branch에 MR 보내기

```
git clone https://github.com/Jinops/ssafy-algorithm-study.git
```

```
git checkout -b "jwp"
```

```
git checkout "jwp
```

```
git add .
```
```
git commit -m "커밋 내용"
```

```
git push origin jwp
```

<img width="746" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/3c8df7c7-ca2d-4ae4-948f-d35e03d54d54">

<img width="1009" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/a2c93f63-775a-4dcd-a789-e2550250246b">

<img width="750" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/09531912-c64e-49d4-b8ce-795c370b4d29">

```
git pull
```

