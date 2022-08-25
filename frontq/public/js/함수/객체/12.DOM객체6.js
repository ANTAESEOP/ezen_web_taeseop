
/* 왼쪽방양키 = 37 위쪽 방향키 = 38 */






/* 별의 초기 설정 */
const star = document.querySelector('h1')
star.style.position ='absolute' /* css 조작 = 포지션 : 절대위치 */

/* 별의 이동을 출력하는 기능 */
let [ x, y ] = [ 0, 0 ] /* 키보드 이동 값 */

/*
let x = 0 left 위치 저장하는 변수
let y = 0 top 위치 저장하는 변수
*/

const block = 20 /* 이동 단위 */

/*
const left = 37
const up = 38
const right = 39
const down = 40
*/

const print = () => {
	star.style.left = `${x * block}px`
	star.style.top = `${y * block}px`
}
print()

const [left, up, right, down ] = [37, 38, 39, 40]

document.body.addEventListener('keydown', (event) => {
	// if : 물리제어 [경수의 수가 정해져 있지 않은경우 ]
	// switch [ break ] : 값 제어 [ 정해진 경우의 ]
	switch (event.keyCode) {
		case left :
		x -= 1
		break
		case up :
		y -= 1
		break
		case right :
		x += 1
		break
		case down :
		y += 1
		break
	} // switch end
	print() // x와 y변경 후 함수 호출
} ) // 키보드 이벤트 함수 end