package com.galagidae.broadboard.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val shift_lock: ImageVector
  get() {
    if (_shift_lock != null) {
      return _shift_lock!!
    }
    _shift_lock =
      ImageVector.Builder(
          name = "shift_lock",
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
            // Outer arrow + stem
            moveTo(8f, 18f)
            verticalLineTo(13f)
            horizontalLineTo(3f)
            lineTo(12f, 2f)
            lineToRelative(9f, 11f)
            horizontalLineTo(16f)
            verticalLineToRelative(5f)
            horizontalLineTo(8f)
            close()

            // Bottom bar
            moveTo(4f, 22f)
            verticalLineTo(20f)
            horizontalLineTo(20f)
            verticalLineToRelative(2f)
            horizontalLineTo(4f)
            close()
          }
        }
        .build()
    return _shift_lock!!
  }

private var _shift_lock: ImageVector? = null