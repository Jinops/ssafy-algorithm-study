## 양식
- 주간 폴더명을 `week01` 형식으로 만들기
- 폴더 내 README파일을 만들고, 문제 및 풀이기간을 명시하기
- 출제 사이트 및 문제 번호로 폴더 만들기 ex) `BOJ_1012`, `SWEA_2806`
> 빈 폴더를 commit하는 방법: 폴더 내에 `.gitkeep` 파일 생성
- 코드 파일명은 `SWEA_2806_박진우.java` 형식으로 하기

## Branch 관리
- 문제 출제자가 주간 폴더, 문제별 폴더 및 README를 작성 시 Main에 바로 작성하기 
- **문제를 풀 때에는, Main에 바로 Commit하지 않고, 자기 Branch에서 하기**
- Branch 이름은 다음과 이름 초성-주차로 하기 `mhk-01, jwp-01, jyb-01, mhw-02, smy-02, hyl-03`
- 문제를 다 풀었을 때, Main Branch에 Merge Request 보내기

### How to

1. main branch를 최신으로 업데이트하기
```
git checkout main
git pull
```

2. 자기의 branch로 바꾸기
```
git checkout jwp-01
```
 - branch가 없을 때, -b 옵션을 넣으면 branch를 새로 생성
```
git checkout -b jwp-01
```

3. 자기 branch에 main의 내용을 merge 하기 (최신화)
```
git checkout jwp-01
```

4. 문제 모두 푼 후, 파일 add 및 commit 하기
```
git add .
git commit -m "커밋 내용"
```

5. 리모트 레포지토리의 자기 branch로 push하기
```
git push origin jwp-01
```

6. Pull requests - New pull reqest
<br><kbd><img width="229" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/8a51500d-6760-4c31-814c-2f5d6159c4cc"></kbd>

7. base: main, compare: 작업한 branch로 설정하여, Create pull reqest
<br><kbd><img width="640" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/6f290657-9bf5-4c6d-8130-7584f7ed23a3f"></kbd>

8. 내용 간단하게 작성하고, Assignee를 해당 주 문제 출제자로 설정
<br><kbd><img width="640" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/a2606bcb-0dd0-45c2-970e-b9e665fb92e2"></kbd>

9. (문제 출제자) Pull Reqest 확인 후 Main에 Merge하기
<br><kbd><<img width="640" alt="image" src="https://github.com/Jinops/ssafy-algorithm-study/assets/46846964/71a8a8f9-948a-4b5d-8e13-9e71d1051011"></kbd>

> :warning: **Merge가 되면, 리모트 레포지토리에서 해당 branch는 제거됩니다**.




