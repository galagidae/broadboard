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
public val keyboard: ImageVector
  get() {
    if (_keyboard != null) {
      return _keyboard!!
    }
    _keyboard =
      ImageVector.Builder(
          name = "keyboard",
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
            moveTo(4f, 19f)
            quadTo(3.18f, 19f, 2.59f, 18.41f)
            reflectiveQuadTo(2f, 17f)
            verticalLineTo(7f)
            quadTo(2f, 6.18f, 2.59f, 5.59f)
            reflectiveQuadTo(4f, 5f)
            horizontalLineTo(20f)
            quadToRelative(0.83f, 0f, 1.41f, 0.59f)
            quadTo(22f, 6.18f, 22f, 7f)
            verticalLineTo(17f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(20f, 19f)
            horizontalLineTo(4f)
            close()
            moveTo(4f, 17f)
            horizontalLineTo(20f)
            verticalLineTo(7f)
            horizontalLineTo(4f)
            verticalLineTo(17f)
            close()
            moveTo(8f, 16f)
            horizontalLineToRelative(8f)
            verticalLineTo(14f)
            horizontalLineTo(8f)
            verticalLineToRelative(2f)
            close()
            moveTo(5f, 13f)
            horizontalLineTo(7f)
            verticalLineTo(11f)
            horizontalLineTo(5f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(11f)
            horizontalLineTo(8f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(11f)
            horizontalLineTo(11f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(11f)
            horizontalLineTo(14f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(11f)
            horizontalLineTo(17f)
            verticalLineToRelative(2f)
            close()
            moveTo(5f, 10f)
            horizontalLineTo(7f)
            verticalLineTo(8f)
            horizontalLineTo(5f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(8f)
            horizontalLineTo(8f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(8f)
            horizontalLineTo(11f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(8f)
            horizontalLineTo(14f)
            verticalLineToRelative(2f)
            close()
            moveToRelative(3f, 0f)
            horizontalLineToRelative(2f)
            verticalLineTo(8f)
            horizontalLineTo(17f)
            verticalLineToRelative(2f)
            close()
            moveTo(4f, 17f)
            verticalLineTo(7f)
            verticalLineTo(17f)
            close()
          }
        }
        .build()
    return _keyboard!!
  }

private var _keyboard: ImageVector? = null
