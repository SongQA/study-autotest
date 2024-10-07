package mobile.common

object ErrorMessages {

    object Element {
        const val DISPLAY = "Element가 화면에 노출됩니다."
        const val NOT_DISPLAY = "해당 Element를 화면에서 찾을 수 없습니다."
        const val NOT_CLICKABLE = "해당 Element를 클릭할 수 없습니다."
        const val NOT_ENABLED = "해당 Element가 활성화되지 않았습니다."
    }

    object Action {
        const val CLICK_FAILED = "클릭 동작이 실패했습니다."
        const val INPUT_FAILED = "입력 동작이 실패했습니다."
        const val SCROLL_FAILED = "스크롤 동작이 실패했습니다."
        const val SWIPE_FAILED = "스와이프 동작이 실패했습니다."
        const val DRAG_AND_DROP_FAILED = "드래그 앤 드롭 동작이 실패했습니다."
    }
}
