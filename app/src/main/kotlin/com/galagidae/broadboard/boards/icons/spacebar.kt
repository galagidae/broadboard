package com.galagidae.broadboard.boards.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val space_bar: ImageVector
  get() {
    if (_space_bar != null) {
      return _space_bar!!
    }
    _space_bar =
      ImageVector.Builder(
          name = "space_bar",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.Companion.NonZero,
          ) {
            moveTo(4f, 15f)
            verticalLineTo(9f)
            horizontalLineTo(6f)
            verticalLineToRelative(4f)
            horizontalLineTo(18f)
            verticalLineTo(9f)
            horizontalLineToRelative(2f)
            verticalLineToRelative(6f)
            horizontalLineTo(4f)
            close()
          }
        }
        .build()
    return _space_bar!!
  }

private var _space_bar: ImageVector? = null