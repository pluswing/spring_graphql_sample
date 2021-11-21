import React, { useCallback, useState } from 'react'
import { useCreateCommentMutation } from '../generated/graphql';


const CreateComment = ({postId} : {postId: string}) => {
  const [name, setName] = useState('')
  const [content, setContent] = useState('')

  const [state, executeMutation] = useCreateCommentMutation()

  const submit = useCallback(() => {
    executeMutation({ postId, name, content })
  }, [executeMutation, postId, name, content ])

  return (
    <div>
      <div className="flex flex-column mt3">
        <input
          className="mb2"
          value={name}
          onChange={e => setName(e.target.value)}
          type="text"
          placeholder="title"
        />
        <br/>
        <textarea
          className="mb2"
          value={content}
          onChange={e => setContent(e.target.value)}
          placeholder="content"
        />
      </div>
      <button
        disabled={state.fetching}
        onClick={submit}>
        Submit
      </button>
    </div>
  )
}

export default CreateComment
